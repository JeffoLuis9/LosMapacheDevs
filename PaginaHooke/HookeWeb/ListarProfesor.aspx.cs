using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarProfesor : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            //Listar Profesores;
        }

        protected void gvProfesores_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int idProfesor = Convert.ToInt32(e.CommandArgument);

            if (e.CommandName == "ModificarProfesor")
            {
                // Redirige a RegistrarProfesor.aspx con el ID del profesor para modificar
                Response.Redirect($"RegistrarProfesor.aspx?id={idProfesor}");
            }
            else if (e.CommandName == "EliminarProfesor")
            {
                // Aquí se llama a la lógica de eliminación.
                // Como ya tenemos OnClientClick para la confirmación, podemos eliminar directamente.
                // EliminarProfesor(idUsuario);
            }
        }

        protected void gvProfesores_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            //Listar Profesores;
        }
    }
}