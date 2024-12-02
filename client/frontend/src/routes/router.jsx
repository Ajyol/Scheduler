import { Routes, Route } from "react-router-dom";
import EmployeeDashboard from "../components/EmployeeDashboard"; 

function AppRoutes() {
  return (
    <Routes>
      <Route path="/employees" element={<EmployeeDashboard />} /> {/* Employee Dashboard route */}
    </Routes>
  );
}

export default AppRoutes;
