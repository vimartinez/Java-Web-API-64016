import './App.css';
import ApiConsumer from './components/ApiConsumer';
import Home from './components/Home';
import Contact from './components/Contact';
import Menu from './components/menu';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import About from './components/About';

function App() {
  return (
    <Router>
      <div className="App">
        <Menu name="Java Web API" />
        <Routes>
          <Route path='/' element={<Home/>} />
          <Route path='/contact' element={<Contact/>} />
          <Route path='/data' element={<ApiConsumer />} />
          <Route path='/about' element={<About />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
