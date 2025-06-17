<<<<<<< HEAD
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
=======
﻿using System;
>>>>>>> origin/BranchAndres
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarCurso : System.Web.UI.Page
    {
<<<<<<< HEAD
        private curso curso;
        private CursoWSClient cursoWS;
        private estado estado;
        protected void Page_Init(object sender, EventArgs e)
        {
            
=======
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
>>>>>>> origin/BranchAndres
                if (Request.QueryString["id"] != null)
                {
                    int cursoId;
                    if (int.TryParse(Request.QueryString["id"], out cursoId))
                    {
<<<<<<< HEAD
                        cursoWS = new CursoWSClient();
                        curso = cursoWS.obtenerCurso(cursoId);
                        hdnCursoId.Value = cursoId.ToString();
                        estado = estado.Modificar;
                        formTitle.InnerText = "Modificar Curso";
                        litPageTitle.Text = "Modificar Curso";
                        btnRegistrar.Text = "Guardar Cambios";
                        txtCodigo.Text = curso.codigo;
                        txtNombre.Text = curso.nombre;
                        txtNivel.Text = curso.nivel.ToString();
                        txtHoraInicio.Text = curso.horaInicio.ToString();
                        txtHoraFin.Text = curso.horaFin.ToString();
=======
                        hdnCursoId.Value = cursoId.ToString();
                        formTitle.InnerText = "Modificar Curso";
                        litPageTitle.Text = "Modificar Curso";
                        btnRegistrar.Text = "Guardar Cambios";
                    }
                    else
                    {
                        Response.Redirect("ListarCursos.aspx");
>>>>>>> origin/BranchAndres
                    }
                }
                else
                {
<<<<<<< HEAD
                    estado = estado.Nuevo;
=======
>>>>>>> origin/BranchAndres
                    hdnCursoId.Value = "0";
                    formTitle.InnerText = "Registrar Curso";
                    litPageTitle.Text = "Registrar Curso";
                    btnRegistrar.Text = "Registrar Curso";
<<<<<<< HEAD
                    curso = new curso();
                }
            }
     

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            curso.codigo = txtCodigo.Text;
            curso.nombre = txtNombre.Text;
            curso.nivel = Int32.Parse(txtNivel.Text);
            curso.horaInicio = Int32.Parse(txtHoraInicio.Text);
            curso.horaFin = Int32.Parse(txtHoraFin.Text);
            cursoWS.guardarCurso(curso, estado);
=======
                }
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
>>>>>>> origin/BranchAndres
            Response.Redirect("ListarCursos.aspx");
        }
    }
}