
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarProfesor : System.Web.UI.Page
    {

        private ProfesorWSClient profesorWS;
        private profesor profesor;
        private estado estado;
        private CursoWSClient cursoWS;
        private curso curso;
        protected void Page_Init(object sender, EventArgs e)
        {
            cursoWS = new CursoWSClient();
            ddlCurso.DataSource = new BindingList<curso>(cursoWS.listarCursos());
            ddlCurso.DataTextField = "nombre";
            ddlCurso.DataValueField = "id";
            ddlCurso.DataBind();
            ddlCurso.Items.Insert(0, new ListItem("-- Seleccione Curso --", ""));

            if (Request.QueryString["id"] != null)
            {
                int profesorId;
                if (int.TryParse(Request.QueryString["id"], out profesorId))
                {
                    profesorWS = new ProfesorWSClient();
                    profesor = profesorWS.obtenerProfesor(profesorId);
                    txtNombre.Text = profesor.nombre;
                    txtApellido.Text = profesor.apellido;
                    txtDNI.Text = profesor.DNI;
                    txtEmail.Text = profesor.email;
                    txtFechaNacimiento.Text = (profesor.fechaNacimiento).ToString();
                    ddlCurso.SelectedValue = profesor.curso.id.ToString();
                    
                    
                    estado = estado.Modificar;
                    formTitle.InnerText = "Modificar Profesor"; 
                    litPageTitle.Text = "Modificar Profesor";
                    btnRegistrar.Text = "Guardar Cambios";
     
                }
            }
            else
            {
                estado = estado.Nuevo;
                formTitle.InnerText = "Registrar Profesor";
                litPageTitle.Text = "Registrar Profesor";
                btnRegistrar.Text = "Registrar Profesor";
                profesor = new profesor();
                profesor.tipoUsuario = 'P';
            }
        }
       

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            profesorWS = new ProfesorWSClient();
            cursoWS = new CursoWSClient();
            profesor.nombre = txtNombre.Text;
            profesor.apellido = txtApellido.Text;
            profesor.DNI = txtDNI.Text;
            profesor.email = txtEmail.Text;
            profesor.fechaNacimiento = DateTime.Parse(txtFechaNacimiento.Text);
            profesor.fechaNacimientoSpecified = true;
            curso = new curso();
            curso = cursoWS.obtenerCurso(Int32.Parse(ddlCurso.SelectedValue));
            profesor.curso = curso;
            profesor.password = txtPassword.Text;
            
            profesorWS.guardarProfesor(profesor, estado);
            Response.Redirect("ListarProfesor.aspx");
        }
    }
}