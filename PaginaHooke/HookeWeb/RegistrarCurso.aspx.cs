using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarCurso : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                if (Request.QueryString["id"] != null)
                {
                    int cursoId;
                    if (int.TryParse(Request.QueryString["id"], out cursoId))
                    {
                        hdnCursoId.Value = cursoId.ToString();
                        formTitle.InnerText = "Modificar Curso";
                        litPageTitle.Text = "Modificar Curso";
                        btnRegistrar.Text = "Guardar Cambios";
                    }
                    else
                    {
                        Response.Redirect("ListarCursos.aspx");
                    }
                }
                else
                {
                    hdnCursoId.Value = "0";
                    formTitle.InnerText = "Registrar Curso";
                    litPageTitle.Text = "Registrar Curso";
                    btnRegistrar.Text = "Registrar Curso";
                }
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarCursos.aspx");
        }
    }
}