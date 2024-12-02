import { BrowserRouter as Router } from "react-router-dom";
import AppRoutes from "./routes/router";
import './App.css';

function App() {
  return (
    <Router>
      <AppRoutes />
    </Router>
  );
}

export default App;
