
﻿using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
using System.EnterpriseServices;

using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class RegistrarTipoSesion : System.Web.UI.Page
    {

        private estado estado;
        private TipoSesionWSClient tipoSesionWS;
        private tipoSesion tipoSesion;
        protected void Page_Init(object sender, EventArgs e)
        {
             
            if (Request.QueryString["id"] != null)
            {
                int tipoSesionId;
                if (int.TryParse(Request.QueryString["id"], out tipoSesionId))
                {
                    tipoSesionWS = new TipoSesionWSClient();
                    tipoSesion = tipoSesionWS.obtenerTipoSesion(tipoSesionId);
                    estado = estado.Modificar;
                    txtPrecio.Text = tipoSesion.precio.ToString();
                    txtTipo.Text = tipoSesion.tipo;
                    formTitle.InnerText = "Modificar Tipo de Sesión";
                    litPageTitle.Text = "Modificar Tipo de Sesión";
                    btnRegistrar.Text = "Guardar Cambios";
                }
            }
            else
            {
                estado = estado.Nuevo;
                formTitle.InnerText = "Registrar Tipo de Sesión";
                litPageTitle.Text = "Registrar Tipo de Sesión";
                btnRegistrar.Text = "Registrar Tipo de Sesión";
                tipoSesion = new tipoSesion();
            }
        }
        

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            tipoSesionWS = new TipoSesionWSClient();
            tipoSesion.precio = Double.Parse(txtPrecio.Text);
            tipoSesion.tipo = txtTipo.Text;
            tipoSesionWS.guardarTipoSesion(tipoSesion, estado);
            Response.Redirect("ListarTipoSesiones.aspx");
        }
    }
}