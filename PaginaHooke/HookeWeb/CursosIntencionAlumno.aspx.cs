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
        
        }

        protected void gvCursosAlumno_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            Response.Redirect("Voucher.aspx");
        }
    }
}