import { Form } from "./components/cadastro/Form";
import { Header } from "./components/Header/Header.jsx";
import "./App.css";
import { FilaComponent } from "./components/fila/FilaComponent/FilaComponent.jsx";
import { Historico } from "./components/historico/Historico";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import "./App.css";

function App() {
  return (
    <Router>
      <main>
        <Header />
        <div className="main-container">
          <Routes>
            <Route path="/" element={<Form />} />
            <Route path="/form" element={<Form />} />
            <Route path="/fila" element={<FilaComponent />} />
            <Route path="/historico" element={<Historico />} />
          </Routes>
        </div>
      </main>
    </Router>
  );
}

export default App;
