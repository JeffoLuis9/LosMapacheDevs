using PUCP.Edu.Pe.Prog03HookeWeb.Web.HookeWS;
using System;
using System.Collections.Generic;
<<<<<<< HEAD
using System.ComponentModel;
using System.Data;
using System.Drawing.Printing;
using System.Linq;
using System.ServiceModel.Channels;
=======
using System.Data;
using System.Linq;
>>>>>>> origin/BranchAndres
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace PUCP.Edu.Pe.Prog03HookeWeb.Web
{
    public partial class ListarProfesor : System.Web.UI.Page
    {
<<<<<<< HEAD
        private ProfesorWSClient profesorWS;
        private BindingList<profesor> profesores;
        protected void Page_Load(object sender, EventArgs e)
        {
            profesorWS = new ProfesorWSClient();
            profesores = new BindingList<profesor>(profesorWS.listarProfesores());
            gvProfesores.DataSource = profesores;
            gvProfesores.DataBind();
=======
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataTable dt = new DataTable();
                dt.Columns.Add("idUsuario", typeof(int));
                dt.Columns.Add("NombreCompleto", typeof(string));
                dt.Columns.Add("NombreCurso", typeof(string));

                // Agregando registros de ejemplo
                dt.Rows.Add(1, "Juan Pérez", "Matemáticas I");
                dt.Rows.Add(2, "María García", "Física II");
                dt.Rows.Add(3, "Carlos López", "Química General");
                dt.Rows.Add(4, "Ana Fernández", "Literatura Peruana");
                dt.Rows.Add(5, "Pedro Martínez", "Historia Universal");
                gvProfesores.DataSource = dt;
                gvProfesores.DataBind();
            }
            
            //Listar Profesores;
>>>>>>> origin/BranchAndres
        }

        protected void gvProfesores_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            int idProfesor = Convert.ToInt32(e.CommandArgument);
<<<<<<< HEAD
            if (e.CommandName == "ModificarProfesor")
            {
                
=======

            if (e.CommandName == "ModificarProfesor")
            {
                // Redirige a RegistrarProfesor.aspx con el ID del profesor para modificar
>>>>>>> origin/BranchAndres
                Response.Redirect($"RegistrarProfesor.aspx?id={idProfesor}");
            }
            else if (e.CommandName == "EliminarProfesor")
            {
<<<<<<< HEAD
                profesorWS.eliminarProfesor(idProfesor);
                Response.Redirect("ListarProfesor.aspx");
            }
        }

=======
                // Aquí se llama a la lógica de eliminación.
                // Como ya tenemos OnClientClick para la confirmación, podemos eliminar directamente.
                // EliminarProfesor(idUsuario);
            }
        }

        protected void gvProfesores_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {
            //Listar Profesores;
        }

>>>>>>> origin/BranchAndres
        protected void btnRegistrarNuevo_Click(object sender, EventArgs e)
        {
            Response.Redirect("RegistrarProfesor.aspx");
        }
    }
}