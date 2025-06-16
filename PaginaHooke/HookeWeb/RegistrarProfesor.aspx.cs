using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarProfesor : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {

                if (Request.QueryString["id"] != null)
                {
                    int profesorId;
                    if (int.TryParse(Request.QueryString["id"], out profesorId))
                    {
                        hdnProfesorId.Value = profesorId.ToString(); 

                        formTitle.InnerText = "Modificar Profesor"; 
                        litPageTitle.Text = "Modificar Profesor";
                        btnRegistrar.Text = "Guardar Cambios";

                        
                    }
                    else
                    {
                        Response.Redirect("ListarProfesor.aspx");
                    }
                }
                else
                {
                    hdnProfesorId.Value = "0"; 

                    formTitle.InnerText = "Registrar Profesor";
                    litPageTitle.Text = "Registrar Profesor";
                    btnRegistrar.Text = "Registrar Profesor";
                }
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Write("<script>alert('¡Registro exitoso! Ya puedes iniciar sesión.'); window.location='Administrador.aspx';</script>");
        }
    }
}