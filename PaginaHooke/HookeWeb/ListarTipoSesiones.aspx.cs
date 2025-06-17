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
    public partial class ListarTipoSesiones : System.Web.UI.Page
    {
<<<<<<< HEAD
        private TipoSesionWSClient tipoSesionWS;
        private BindingList<tipoSesion> tipoSesiones;
        protected void Page_Load(object sender, EventArgs e)
        {
            tipoSesionWS = new TipoSesionWSClient(); 
            tipoSesiones = new BindingList<tipoSesion>(tipoSesionWS.listarTipoSesiones());
            gvTipoSesion.DataSource = tipoSesiones;
=======
        protected void Page_Load(object sender, EventArgs e)
        {
            DataTable dt = new DataTable();
            dt.Columns.Add("idModalidad", typeof(int));
            dt.Columns.Add("Tipo", typeof(string));
            dt.Columns.Add("Precio", typeof(decimal)); // Usar decimal para precios

            // Añadir filas de datos de ejemplo
            dt.Rows.Add(1, "Clase Individual", 50.00);
            dt.Rows.Add(2, "Taller Grupal", 35.50);
            dt.Rows.Add(3, "Sesión Especial", 75.00);
            dt.Rows.Add(4, "Clase Virtual", 40.00);

            gvTipoSesion.DataSource = dt;
>>>>>>> origin/BranchAndres
            gvTipoSesion.DataBind();
        }

        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarTipoSesion.aspx");
        }

        protected void gvTipoSesion_RowCommand(object sender, GridViewCommandEventArgs e)
        {
<<<<<<< HEAD
            int idModalidad = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarTipoSesion")
            {
                Response.Redirect($"RegistrarTipoSesion.aspx?id={idModalidad}");
            }
            if (e.CommandName == "EliminarTipoSesion")
            {
                tipoSesionWS.eliminarTipoSesion(idModalidad);
                Response.Redirect("ListarTipoSesiones.aspx");
            }
        }


=======
            if (e.CommandName == "ModificarTipoSesion")
            {
                int idModalidad = Convert.ToInt32(e.CommandArgument);
                Response.Redirect($"RegistrarTipoSesion.aspx?id={idModalidad}");
            }
        }

        protected void gvTipoSesion_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
           
        }
>>>>>>> origin/BranchAndres
    }
}