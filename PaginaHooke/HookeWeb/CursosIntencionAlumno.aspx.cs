using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class CursosIntencionAlumno : System.Web.UI.Page
    {
        protected void Page_PreInit(object sender, EventArgs e)
        {

            if (Session["Rol"] != null)
            {
                string userRole = Session["Rol"].ToString();

                if (userRole == "Administrador")
                {
                    this.MasterPageFile = "~/SiteAdministrador.Master";
                }
                if (userRole == "Alumno")
                {
                    this.MasterPageFile = "~/SiteAlumno.Master"; // Asegúrate de que SiteEstudiante.Master exista
                }

            }

        }
        protected void Page_Load(object sender, EventArgs e)
        {
            DataTable dtCursos = new DataTable();

            // Definir las columnas del DataTable
            dtCursos.Columns.Add("idInscripcion", typeof(int)); // ID único para cada inscripción/fila
            dtCursos.Columns.Add("NombreCurso", typeof(string));
            dtCursos.Columns.Add("NombreProfesor", typeof(string));
            dtCursos.Columns.Add("Intencion", typeof(string)); // "En revisión", "Aceptado"

            // Añadir filas de datos de ejemplo (filtrando por idAlumno simulado)
            // Cursos para Ana García (idUsuario = 101)
            dtCursos.Rows.Add(1, "Matemáticas I", "Juan Pérez", "En revisión");
            dtCursos.Rows.Add(2, "Física Básica", "María López", "Aceptado");
            dtCursos.Rows.Add(3, "Programación Java", "Carlos Rojas", "Aceptado");

            // Filtrar el DataTable por el idAlumno recibido
            // En un escenario real, tu consulta a la BD ya traería solo los cursos del alumno específico.
            DataView dv = new DataView(dtCursos);

            gvCursosAlumno.DataSource = dv; // Usar el DataView filtrado
            gvCursosAlumno.DataBind();
        }

        protected void gvCursosAlumno_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            Response.Redirect("VerVoucher.aspx");
        }
    }
}