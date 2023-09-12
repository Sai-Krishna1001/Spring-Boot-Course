import { useNavigate } from "react-router-dom";
import { isUserLoggedIn, logout } from "../services/AuthService";

const HeaderComponent = () => {

  const isAuth = isUserLoggedIn();

  const navigator = useNavigate();
  
  const handleLogout = () => {
    logout();
    navigator("/login");
  }

  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div className="container">
              
            <a className="navbar-brand" href="http://localhost:3000">Todo Management System</a>
            {
              isAuth && <a className="navbar-brand ml-auto" href="/todos">Todos</a>
            }

            {
              !isAuth && <a className="navbar-brand ml-auto" href="/register">Register</a>
            }
            {
              !isAuth &&  <a className="navbar-brand ml-auto" href="/login">Login</a>
            }
            {
              isAuth &&  <a className="navbar-brand ml-auto" href="/login" onClick={handleLogout}>Logout</a>
            }
           
          </div>
        </nav>
      </header>
    </div>
  )
}

export default HeaderComponent
