
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;


using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class Registrar : System.Web.UI.Page
    {

        private AlumnoWSClient alumnoWS;
        private alumno alumno;
        private estado estado;

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            alumnoWS = new AlumnoWSClient();
            alumno = new alumno();
            alumno.nombre = txtNombre.Text;
            alumno.apellido = txtApellido.Text;
            alumno.DNI = txtDNI.Text;
            alumno.email = txtEmail.Text;
            alumno.fechaNacimiento = DateTime.Parse(txtFechaNacimiento.Text);
            alumno.fechaNacimientoSpecified = true;
            alumno.password = txtPassword.Text;
            alumno.tipoUsuario = 'E';
            alumnoWS.guardarAlumno(alumno, estado.Nuevo);
            Response.Redirect("Login.aspx");

        }
        protected void Page_Load(object sender, EventArgs e)
        {
          
        }

    }
}