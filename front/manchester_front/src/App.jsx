


import { Form } from './components/Form'
import { Header } from './components/Header'
import './App.css'
import { FilaComponent } from './components/FilaComponent'
import   {Historico} from './components/Historico'

// import do router
import {BrowserRouter as Router, Route, Routes} from "react-router-dom"



import './App.css'

function App() {

  return (
    <Router>
    <main>
      <Header />
      <div className='main-container'>
        <Routes>
        <Route path="/" element={<Form />} />
        <Route path="/form" element={<Form/>} />
        <Route path="/fila" element={<FilaComponent/>} />
        <Route path="/historico" element={<Historico/>} />
        </Routes>
      </div>
    </main>
  </Router>
  )
}

export default App


