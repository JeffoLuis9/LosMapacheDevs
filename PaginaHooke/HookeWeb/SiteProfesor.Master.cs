using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class SiteProfesor : System.Web.UI.MasterPage
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            lblUserName.Text = Session["usuario"].ToString();

        }

        protected void lnkLogout_Click(object sender, EventArgs e)
        {
            Session.Clear(); // Elimina todas las variables de sesión
            Session.Abandon(); // Termina la sesión actual

            // 2. Limpiar la cookie de autenticación (si estás usando autenticación por formularios)
            // Esto es importante para cerrar la sesión de forma segura
            System.Web.Security.FormsAuthentication.SignOut();

            // 3. Redirigir a la página principal (normalmente la de login)
            Response.Redirect("~/Login.aspx"); // Asegúrate de que esta sea la ruta correcta a tu página de login
        }
    }
}