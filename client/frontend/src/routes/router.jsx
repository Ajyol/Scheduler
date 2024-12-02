import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import HomePage from '../components/home-page';
import LoginPage from '../components/login-page';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginPage />} />
      </Routes>
    </Router>
  );
}

export default App;
