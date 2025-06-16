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
    public partial class ListarSede : System.Web.UI.Page
    {
        private SedeWSClient sedeWS;
        private BindingList<sede> sedes;

        public ListarSede()
        {
            // Instanciar el servicio web
            this.sedeWS = new SedeWSClient();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            sedeWS = new SedeWSClient();
            
            sedes = new BindingList<sede>(sedeWS.listarSedes().ToList());
            gvSedes.DataSource = sedes;
            gvSedes.DataBind();
        }

        protected void gvSedes_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int idSede = Convert.ToInt32(e.CommandArgument);

            if (e.CommandName == "ModificarSede")
            {
                // Redirige a RegistrarProfesor.aspx con el ID del profesor para modificar
                Response.Redirect($"RegistrarSede.aspx?id={idSede}");
            }
            else if (e.CommandName == "EliminarSede")
            {

                // Aquí se llama a la lógica de eliminación.
                // Como ya tenemos OnClientClick para la confirmación, podemos eliminar directamente.
                // EliminarProfesor(idUsuario);
                gvSedes_RowDeleting(sender, e);
            }
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            // Redirigir a la página de registro de nuevo profesor
            Response.Redirect("GestionarSedes.aspx");
        }



        protected void gvSedes_RowDeleting(object sender, EventArgs e)
        {
            // Obtener el ID del objeto a eliminar
            int idSede = Int32.Parse(((LinkButton)sender).CommandArgument);

            // Llamar al servicio para eliminar
            sedeWS.eliminarSede(idSede);

            // Recargar la página para actualizar la lista
            Response.Redirect("ListarSedes.aspx");
        }



    }
}