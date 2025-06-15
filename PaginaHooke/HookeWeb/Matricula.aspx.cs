using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.ComponentModel;
using System.ServiceModel;
using System.Web.UI.WebControls;
using NodaTime;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class Matricula : System.Web.UI.Page
    {
        private sesion sesion;

        private TipoSesionWSClient tipoSesionWS;
        private SedeWSClient sedeWS;
        private ProfesorWSClient profesorWS;
        private CursoWSClient cursoWS;
        private SesionWSClient sesionWS;
        private BindingList<curso> cursos;
        private BindingList<profesor> profesores;
        private BindingList<tipoSesion> tipoSesiones;
        private BindingList<sede> sedes;
        protected void Page_Load(object sender, EventArgs e)
        {
            tipoSesionWS = new TipoSesionWSClient();
            sedeWS = new SedeWSClient();
            tipoSesiones = new BindingList<tipoSesion>(tipoSesionWS.listarTipoSesiones());
            sedes = new BindingList<sede>(sedeWS.listarSedes());
            DdlTipoSesion.DataSource = tipoSesiones;
            DdlTipoSesion.DataValueField = "idModalidad";
            DdlTipoSesion.DataTextField = "tipo";
            DdlTipoSesion.DataBind();
            DdlSede.DataSource = sedes;
            DdlSede.DataValueField = "id";
            DdlSede.DataTextField = "direccion";
            DdlSede.DataBind();
        }

        protected void BtnBuscarCursos_Click(object sender, EventArgs e)
        {
            int idNivel;
            if (int.TryParse(TxtNivel.Text, out idNivel))
            {
                cursoWS = new CursoWSClient();
                idNivel = int.Parse(TxtNivel.Text);
                cursos = new BindingList<curso>(cursoWS.listarCursosPorNivel(idNivel));
                DdlCursos.DataSource= cursos;
                DdlCursos.DataValueField = "id";
                DdlCursos.DataTextField = "nombre";
                DdlCursos.DataBind();

            }
            
        }

        protected void DdlCursos_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(DdlCursos.SelectedValue))
            {
                int idCurso = int.Parse(DdlCursos.SelectedValue);

                // Obtener los profesores según el curso
                profesorWS = new ProfesorWSClient();
                profesores = new BindingList<profesor>(profesorWS.listarProfesoresPorCurso(idCurso));

                DdlProfesores.DataSource = profesores;
                DdlProfesores.DataValueField = "id";
                DdlProfesores.DataTextField = "nombre";
                DdlProfesores.DataBind();
            }
        }

        protected void BtnRegistrar_Click(object sender, EventArgs e)
        {
            TipoSesionWSClient tipoSesionWS2;
            tipoSesionWS2 = new TipoSesionWSClient();

            SedeWSClient sedeWS2;
            sedeWS2 = new SedeWSClient();

            ProfesorWSClient profesorWS2;
            profesorWS2 = new ProfesorWSClient();

            CursoWSClient cursoWS2;
            cursoWS2 = new CursoWSClient();

            AlumnoWSClient alumnoWS;
            alumnoWS = new AlumnoWSClient();

            sesionWS = new SesionWSClient();

            estado estado;
            estado = estado.Nuevo;
            sesion = new sesion();
            sesion.fecha = DateTime.Parse("2025-04-06");
            sesion.fechaSpecified = true;
            sesion.modalidad = TxtModalidad.Text;
            sesion.curso = cursoWS2.obtenerCurso(1);
            sesion.alumno = alumnoWS.obtenerAlumno(1);
            sesion.tipoSesion = tipoSesionWS2.obtenerTipoSesion(1);
            sesion.profesor = profesorWS2.obtenerProfesor(1);
            sesion.sede = sedeWS2.obtenerSede(1);
            sesion sesionPrueba = new sesion();
            sesionPrueba = sesionWS.obtenerSesion(2);
            if (sesion.alumno.fechaNacimiento == null || sesion.profesor.fechaNacimiento == null)
            {
                // Mostrar mensaje de error o manejar la situación
                Response.Write("Error: Uno o más datos referenciados no existen.");
                return;
            }
            sesionWS.guardarSesion(sesion, estado);
            Response.Redirect("Home.aspx");
        }
    }
}