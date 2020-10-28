import './App.css';
import ViewEmployees from './components/ViewEmployees'
import AddEmployee from './components/AddEmployee';

import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link
  
} from "react-router-dom";



function App() {



  return (

    <Router>
      <div>
        <nav>
            <Link to="/">View Employees</Link> |   <Link to="/add">Add employees</Link>
        </nav>
        <Switch>
        <Route exact  path="/">
          <ViewEmployees></ViewEmployees>
          </Route>
          <Route path="/add">
          <AddEmployee></AddEmployee>
          </Route>
         
    
        </Switch>
      </div>
    </Router>
    
  );
}

export default App;
