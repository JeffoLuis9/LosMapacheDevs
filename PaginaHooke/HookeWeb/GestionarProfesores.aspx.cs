using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class GestionarProfesores : System.Web.UI.Page
    {
        private profesor profesor;
        private estado estado;
        private readonly ProfesorWSClient profesorWS;
        private CursoWSClient cursoWS;

        public GestionarProfesores()
        {
            this.profesorWS = new ProfesorWSClient();
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            string accion = Request.QueryString["accion"];
            if (accion == null)
            {
                lblTitulo.Text = "Registrar Profesor";
                profesor = new profesor();
                estado = estado.Nuevo;
                if (!IsPostBack)
                {
                    Session["profesor"] = null;
                }
            }
            else if (accion == "modificar" && Session["profesor"] != null)
            {
                lblTitulo.Text = "Modificar Profesor";
                estado = estado.Modificar;
                profesor = (profesor)Session["profesor"];

                txtIDProfesor.Text = profesor.id.ToString();
                txtNombre.Text = profesor.nombre;
                txtApellido.Text = profesor.apellido;
                txtEmail.Text = profesor.email;
            }

        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            curso curso = cursoWS.obtenerCurso(1);
            // Asignamos los valores
            profesor profesorGuardar = new profesor();
            if (estado == estado.Nuevo)
            {
                profesorGuardar.nombre = txtNombre.Text;
                profesorGuardar.apellido = txtApellido.Text;
                profesorGuardar.curso = curso;
                profesorGuardar.email = txtEmail.Text;
            }
            else
            {
                profesorGuardar.id = int.Parse(txtIDProfesor.Text);
                profesorGuardar.nombre = txtNombre.Text;
                profesorGuardar.apellido = txtApellido.Text;
                profesorGuardar.curso = curso;
                profesorGuardar.email = txtEmail.Text;
            }

            // Llamada al servicio para guardar
            profesorWS.guardarProfesor(profesorGuardar, estado);

            // Redireccionamos a listar
            Response.Redirect("ListarProfesores.aspx");
        }
    }

}