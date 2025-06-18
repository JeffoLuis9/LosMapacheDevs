using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using HookeWeb;
using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarMatricula : System.Web.UI.Page
    {
        private CursoWSClient cursoWS;
        private curso curso;
        private TipoSesionWSClient tipoSesionWS;
        private tipoSesion tiposesion;
        private ProfesorWSClient profesorWS;
        private profesor profesor;
        private SedeWSClient sedeWS;
        private sede sede;
        private SesionWSClient sesionWS;
        private sesion sesion;
        protected void Page_Init(object sender, EventArgs e)
        { 
            
        }


        protected void Page_Load(object sender, EventArgs e)
        {
            
        }

        protected void btnBuscarCursos_Click (object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            ddlCurso.DataSource = new BindingList<curso>(cursoWS.listarCursosPorNivel(Int32.Parse(ddlNivel.Text)));
            ddlCurso.DataTextField = "nombre";
            ddlCurso.DataValueField = "id";
            ddlCurso.DataBind();

            ddlCurso.Items.Insert(0, new ListItem("-- Seleccione un curso --", "0"));

            tipoSesionWS = new TipoSesionWSClient();
            ddlTipoSesion.DataSource = new BindingList<tipoSesion>(tipoSesionWS.listarTipoSesiones());
            ddlTipoSesion.DataTextField = "tipo";
            ddlTipoSesion.DataValueField = "idModalidad";
            ddlTipoSesion.DataBind();
            ddlTipoSesion.Items.Insert(0, new ListItem("-- Seleccione un tipo de sesion--", "0"));


            sedeWS = new SedeWSClient();
            ddlSede.DataSource = new BindingList<sede>(sedeWS.listarSedes());
            ddlSede.DataTextField = "direccion";
            ddlSede.DataValueField = "id";
            ddlSede.DataBind();
            ddlSede.Items.Insert(0, new ListItem("-- Seleccione una Sede --", "0"));
        }

       

        protected void ddlCurso_SelectedIndexChanged(object sender, EventArgs e)
        {
            int idCursoSeleccionado = int.Parse(ddlCurso.SelectedValue);
            profesorWS = new ProfesorWSClient();
            ddlProfesor.DataSource = new BindingList<profesor>(profesorWS.listarProfesoresPorCurso(idCursoSeleccionado));
            ddlProfesor.DataTextField = "nombre";
            ddlProfesor.DataValueField = "id";
            ddlProfesor.DataBind();

            ddlProfesor.Items.Insert(0, new ListItem("-- Seleccione un profesor --", "0"));
        }
        protected void btnAccion_Click(object sender, EventArgs e)
        {
            sesionWS = new SesionWSClient();
            sesion = new sesion();

            sesion.fecha = DateTime.Now;
            sesion.fechaSpecified = true;
            string modalidadSeleccionada = ddlModalidad.SelectedValue;
            sesion.modalidad = modalidadSeleccionada;
            sesion.curso = new curso();
            sesion.curso.id = int.Parse(ddlCurso.SelectedValue);
            sesion.alumno = new alumno();
            sesion.alumno.id = int.Parse(Session["id"].ToString());
            sesion.profesor = new profesor();
            sesion.profesor.id = int.Parse(ddlProfesor.SelectedValue);
            sesion.tipoSesion = new tipoSesion();
            sesion.tipoSesion.idModalidad = int.Parse(ddlTipoSesion.SelectedValue);
            sesion.sede = new sede();
            sesion.sede.id = int.Parse(ddlSede.SelectedValue);


            sesionWS.guardarSesion(sesion, estado.Nuevo);

            Response.Redirect("CursosIntencionAlumno.aspx");
        }

        protected void btnCancelar_Click(object sender, EventArgs e)
        {
            


            Response.Redirect("CursosIntencionAlumno.aspx");
        }
    }
}