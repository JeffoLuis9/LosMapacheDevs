using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarProfesores : System.Web.UI.Page
    {
        // Proxy al servicio web
        private ProfesorWSClient profesorWS;
        // Lista de profesores para el GridView
        private BindingList<profesor> profesores;

        public ListarProfesores()
        {
            // Instanciar el servicio web
            this.profesorWS = new ProfesorWSClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            // Cargar profesores desde el servicio al inicializar la página
            profesores = new BindingList<profesor>(profesorWS.listarProfesores().ToList());
            gvProfesores.DataSource = profesores;
            gvProfesores.DataBind();

        }
        protected void gvProfesores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            // Cambiar de página
            gvProfesores.PageIndex = e.NewPageIndex;
            gvProfesores.DataSource = profesores;
            gvProfesores.DataBind();
        }

        protected void lbRegistrar_Click(object sender, EventArgs e)
        {
            // Redirigir a la página de registro de nuevo profesor
            Response.Redirect("GestionarProfesores.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            // Obtener el ID del profesor a modificar
            int idProfesor = Int32.Parse(((LinkButton)sender).CommandArgument);

            // Buscar el profesor en la lista
            profesor profesor = profesores.SingleOrDefault(p => p.id == idProfesor);

            if (profesor != null)
            {
                // Guardar el profesor en sesión para que esté disponible en la página de modificación
                Session["profesor"] = profesor;
                Response.Redirect("GestionarProfesores.aspx?accion=modificar");
            }
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            // Obtener el ID del profesor a eliminar
            int idProfesor = Int32.Parse(((LinkButton)sender).CommandArgument);

            // Llamar al servicio para eliminar
            profesorWS.eliminarProfesor(idProfesor);

            // Recargar la página para actualizar la lista
            Response.Redirect("ListarProfesores.aspx");
        }
    }
}