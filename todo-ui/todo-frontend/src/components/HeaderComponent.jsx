import { isUserLoggedIn } from "../services/AuthService";

const HeaderComponent = () => {

  const isAuth = isUserLoggedIn();

  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-md navbar-dark bg-dark">
          <div className="container">
              
            <a className="navbar-brand" href="http://localhost:3000">Todo Management System</a>
            
            <a className="navbar-brand ml-auto" href="/todos">Todos</a>

            <a className="navbar-brand ml-auto" href="/register">Register</a>
            
            <a className="navbar-brand ml-auto" href="/login">Login</a>
          </div>
        </nav>
      </header>
    </div>
  )
}

export default HeaderComponent
