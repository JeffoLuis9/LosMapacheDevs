
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
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

            int idCurso = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarCurso")
            {
                
                Response.Redirect($"RegistrarCurso.aspx?id={idCurso}");
            }
            if (e.CommandName == "EliminarCurso")
            {
                
                cursoWS.eliminarCurso(idCurso);
                Response.Redirect("ListarCursos.aspx");
            }
        }


     

        protected void gvCursos_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {

        }

    }
}