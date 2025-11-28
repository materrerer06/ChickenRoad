import { useState } from 'react'
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from './components/Header'
import './App.css'
import Play from './components/Play'
import Poradnik from './components/Poradnik'
import Footer from './components/Footer'

function App() {
  return (
<Router>
    <div>
      <Header />
      <main style={{ paddingTop: "90px" }}>
        <Play />
      </main>
      <Footer />
    </div>
    </Router>
  );
}

export default App
