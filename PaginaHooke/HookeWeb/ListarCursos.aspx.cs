<<<<<<< HEAD
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
=======
﻿using System;
using System.Collections.Generic;
>>>>>>> origin/BranchAndres
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarCursos : System.Web.UI.Page
    {
<<<<<<< HEAD
        private CursoWSClient cursoWS;
        private BindingList<curso> cursos;
        protected void Page_Load(object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            cursos = new BindingList<curso>(cursoWS.listarCursos());
            gvCursos.DataSource = cursos;
=======
        protected void Page_Load(object sender, EventArgs e)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("idCurso", typeof(int));
            dt.Columns.Add("Codigo", typeof(string));
            dt.Columns.Add("Nombre", typeof(string));


            // Añadir filas de datos de ejemplo
            dt.Rows.Add(1, "MAT101", "Matemáticas I");
            dt.Rows.Add(2, "FIS203", "Física Moderna");
            dt.Rows.Add(3, "HIST105", "Historia del Perú");
            dt.Rows.Add(4, "PROG301", "Programación Avanzada");
            dt.Rows.Add(5, "ARTE100", "Apreciación Artística");

            gvCursos.DataSource = dt;
>>>>>>> origin/BranchAndres
            gvCursos.DataBind();
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarCurso.aspx");
        }

        protected void gvCursos_RowCommand(object sender, GridViewCommandEventArgs e)
        {
<<<<<<< HEAD
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


       
=======
            if (e.CommandName == "ModificarCurso")
            {
                int idCurso = Convert.ToInt32(e.CommandArgument);
                Response.Redirect($"RegistrarCurso.aspx?id={idCurso}");
            }
        }

        protected void gvCursos_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {

        }
>>>>>>> origin/BranchAndres
    }
}