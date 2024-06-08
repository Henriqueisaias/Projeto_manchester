import { FormCadastro } from "./components/cadastro/FormCadastro.jsx";
import { Header } from "./components/Header/Header.jsx";
import "./App.css";
import { FilaComponent } from "./components/fila/FilaComponent/FilaComponent.jsx";
import { HistoricoComponent } from "./components/historico/HistoricoComponent.jsx";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import "./App.css";

function App() {
  return (
    <Router>
      <main>
        <Header />
        <div className="main-container">
          <Routes>
            <Route path="/" element={<FormCadastro />} />
            <Route path="/form" element={<FormCadastro />} />
            <Route path="/fila" element={<FilaComponent />} />
            <Route path="/historico" element={<HistoricoComponent />} />
          </Routes>
        </div>
      </main>
    </Router>
  );
}

export default App;
