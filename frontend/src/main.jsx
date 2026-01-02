import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import "flowbite"
import RouteApp from './routing/routeApp'
import { BrowserRouter } from 'react-router-dom'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <BrowserRouter>
      <RouteApp />
    </BrowserRouter>
  </StrictMode>,
)
