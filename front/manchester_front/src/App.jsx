// import { useState } from 'react'


import { Form } from './components/Form'
import { Header } from './components/Header'
import './App.css'

// import do router
// import {BrowserRouter as Router, Route, Switch} from "react-router-dom"



import './App.css'

function App() {

  return (
    <main>
      <Header/>
      <div className='main-container'>
       <Form/>
      </div>
    </main>
  )
}

export default App
