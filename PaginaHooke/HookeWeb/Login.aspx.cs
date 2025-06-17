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
    public partial class Login : System.Web.UI.Page
    {
<<<<<<< HEAD
        private UsuarioWSClient usuarioWS;
        private AlumnoWSClient alumnoWS;
        private ProfesorWSClient profesorWS;
        private alumno alumno;
        private profesor profesor;
        protected void btnLogin_Click(object sender, EventArgs e)
        {
            usuarioWS = new UsuarioWSClient();
            alumnoWS = new AlumnoWSClient();
            profesorWS = new ProfesorWSClient();
            string email = txtEmail.Text;
            string password = txtPassword.Text;
            int idUsuario = usuarioWS.verificarCorreo(email);
            if (idUsuario != 0)
            {
                alumno = alumnoWS.obtenerAlumno(idUsuario);
                profesor = profesorWS.obtenerProfesor(idUsuario);
                if (alumno != null)
                {
                    if (alumno.password == password)
                    {
                        Session["id"] = idUsuario;
                        Session["usuario"] = alumno.nombre + " " + alumno.apellido;
                        Session["Rol"] = "Alumno";
                        Response.Redirect("Alumno.aspx");
                    }
                }
                else if (profesor != null)
                {
                    if (profesor.password == password)
                    {
                        Session["id"] = idUsuario;
                        Session["usuario"] = profesor.nombre + " " + profesor.apellido;
                        Session["Rol"] = "Profesor";
                        Response.Redirect("Profesor.aspx");
                    }
                }
                else if(password == "encriptado3")
                {
                    Session["id"] = idUsuario;
                    Session["usuario"] = "David Cutisaca";
                    Session["Rol"] = "Administrador";
                    Response.Redirect("Administrador.aspx");
                }
            }

            lblErrorMessage.Text = "Correo o contraseña incorrecto";
=======
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
>>>>>>> origin/BranchAndres

        }

        protected void btnRegister_Click(object sender, EventArgs e)
        {
            Response.Redirect("Registrar.aspx");
        }
    }
}