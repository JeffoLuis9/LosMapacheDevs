using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarCursos : System.Web.UI.Page
    {
        private CursoWSClient cursoWS;
        private BindingList<curso> cursos;
        protected void Page_Load(object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            cursos = new BindingList<curso>(cursoWS.listarCursos());
            gvCursos.DataSource = cursos;
            gvCursos.DataBind();
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarCurso.aspx");
        }

        protected void gvCursos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName == "ModificarCurso")
            {
                int idCurso = Convert.ToInt32(e.CommandArgument);
                Response.Redirect($"RegistrarCurso.aspx?id={idCurso}");
            }
        }

        protected void gvCursos_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {

        }

       
    }
}