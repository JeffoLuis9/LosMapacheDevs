using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarTipoSesiones : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("idModalidad", typeof(int));
            dt.Columns.Add("Tipo", typeof(string));
            dt.Columns.Add("Precio", typeof(decimal)); // Usar decimal para precios

            // Añadir filas de datos de ejemplo
            dt.Rows.Add(1, "Clase Individual", 50.00);
            dt.Rows.Add(2, "Taller Grupal", 35.50);
            dt.Rows.Add(3, "Sesión Especial", 75.00);
            dt.Rows.Add(4, "Clase Virtual", 40.00);

            gvTipoSesion.DataSource = dt;
            gvTipoSesion.DataBind();
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarTipoSesion.aspx");
        }

        protected void gvTipoSesion_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "ModificarTipoSesion")
            {
                int idModalidad = Convert.ToInt32(e.CommandArgument);
                Response.Redirect($"RegistrarTipoSesion.aspx?id={idModalidad}");
            }
        }

        protected void gvTipoSesion_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
           
        }
    }
}