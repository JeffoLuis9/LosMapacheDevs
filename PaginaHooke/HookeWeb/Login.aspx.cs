using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class Login : System.Web.UI.Page
    {
        protected void btnLogin_Click(object sender, EventArgs e)
        {

            // Redirigir a la página correspondiente (Pagina1.aspx, Pagina2.aspx, etc.)
            // Aquí debes implementar tu lógica de redirección basada en el tipo de usuario o rol
            if (txtEmail.Text == "administrador@gmail.com" && txtPassword.Text == "prueba1") // Ejemplo de lógica
            {
                Session["UserId"] = 1;
                Session["UserName"] = "David Cutisaca";
                Response.Redirect("Administrador.aspx");
            }
            else if (txtEmail.Text == "profesor@gmail.com" && txtPassword.Text == "prueba1")
            {
                Session["UserId"] = 2;
                Session["UserName"] = "Andres Huaman";
                Response.Redirect("Profesor.aspx");
            }
            else if (txtEmail.Text == "alumno@gmail.com" && txtPassword.Text == "prueba1")
            {
                Session["UserId"] = 3;
                Session["UserName"] = "Jefferson Robles";
                Response.Redirect("Alumno.aspx");
            }
            else
            {
                lblErrorMessage.Text = "Correo o contraseña incorrecto";
            }

        }

        protected void btnRegister_Click(object sender, EventArgs e)
        {
            Response.Redirect("Registrar.aspx");
        }
    }
}