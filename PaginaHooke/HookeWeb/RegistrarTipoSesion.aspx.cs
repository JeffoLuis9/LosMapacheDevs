using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarTipoSesion : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Request.QueryString["id"] != null)
                {
                    int tipoSesionId;
                    if (int.TryParse(Request.QueryString["id"], out tipoSesionId))
                    {
                        hdnTipoSesionId.Value = tipoSesionId.ToString();
                        formTitle.InnerText = "Modificar Tipo de Sesión Existente";
                        litPageTitle.Text = "Modificar Tipo de Sesión";
                        btnRegistrar.Text = "Guardar Cambios";
                    }
                    else
                    {
                        Response.Redirect("ListarTipoSesiones.aspx");
                    }
                }
                else
                {
                    hdnTipoSesionId.Value = "0";
                    formTitle.InnerText = "Registrar Nuevo Tipo de Sesión";
                    litPageTitle.Text = "Registrar Tipo de Sesión";
                    btnRegistrar.Text = "Registrar Tipo de Sesión";
                }
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarTipoSesiones.aspx");
        }
    }
}