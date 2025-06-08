using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;


namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class GestionarCurso : System.Web.UI.Page
    {
        private curso curso;
        private readonly CursoWSClient cursoWS;
        private estado estado;

        public GestionarCurso() {
            this.cursoWS = new CursoWSClient();
        }

        protected void Page_Init(object sender, EventArgs e)
        {
           

            string accion = Request.QueryString["accion"];
            if (accion == null)
            {
                lblTitulo.Text = "Registrar Curso";
                curso = new curso();
                estado = estado.Nuevo;
                if (!IsPostBack)
                {
                    Session["curso"] = null;
                }
            }
            else if (accion == "modificar" && Session["curso"] != null)
            {
                lblTitulo.Text = "Modificar Curso";
                curso = (curso)Session["curso"];
                estado = estado.Modificar;
                txtIDCurso.Text = curso.id.ToString();
                txtNombre.Text = curso.nombre;
                txtCodigo.Text = curso.codigo;
                txtNivel.Text = curso.nivel.ToString();
                txtHoraInicio.Text = curso.horaInicio.ToString();
                txtHoraFin.Text = curso.horaFin.ToString();


            }

        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {

            //empleadoWS = new EmpleadoWSClient();

            //Asignamos los valores
            curso curso;
            if (estado == estado.Nuevo)
            {
                curso = new curso
                {
                    codigo = txtCodigo.Text,
                    nombre = txtNombre.Text,
                    nivel = Int32.Parse(txtNivel.Text),
                    horaInicio = Int32.Parse(txtHoraInicio.Text),
                    horaFin = Int32.Parse(txtHoraFin.Text)

                };
            }
            else
            {
                curso = new curso
                {
                    id = int.Parse(txtIDCurso.Text),
                    codigo = txtCodigo.Text,
                    nombre = txtNombre.Text,
                    nivel = Int32.Parse(txtNivel.Text),
                    horaInicio = Int32.Parse(txtHoraInicio.Text),
                    horaFin = Int32.Parse(txtHoraFin.Text)
                };
            }

            cursoWS.guardarCurso(curso,estado);
            Response.Redirect("Home.aspx");
        }
    }
}