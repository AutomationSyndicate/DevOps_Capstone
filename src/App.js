import React, { useState } from 'react';
import './App.css';
import logo from './logo.svg';
import productsData from './products.json'; // Import the JSON file
import { FaBars } from 'react-icons/fa'; // Import Font Awesome hamburger icon

function App() {
  const [isMenuOpen, setIsMenuOpen] = useState(false); // State to toggle the menu
  const [searchTerm, setSearchTerm] = useState('');
  const [products] = useState(productsData); // Use the imported JSON data
  const [cart, setCart] = useState([]);

  const toggleMenu = () => {
    setIsMenuOpen(!isMenuOpen);
  };

  const scrollToHome = () => {
    const homeSection = document.getElementById('home-section');
    if (homeSection) {
      homeSection.scrollIntoView({ behavior: 'smooth' });
    }
  };

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };

  const handleAddToCart = (product) => {
    setCart([...cart, product]);
    alert(`${product.title} added to cart!`);
  };

  return (
    <div className="App">
      {/* Header Section */}
      <header className="App-header">
        <div className="header-left"></div>
        <div className="header-center">
          <img src={logo} className="App-logo" alt="logo" />
        </div>
        <div className="header-right">
          <FaBars className="hamburger-icon" onClick={toggleMenu} />
        </div>
      </header>

      {/* Hamburger Menu */}
      {isMenuOpen && (
        <div className="hamburger-menu">
          <button className="close-menu" onClick={toggleMenu}>
            ✖
          </button>
          <ul>
            <li onClick={scrollToHome}>Home</li>
            <li>Shop by Category</li>
            <li>Deals</li>
            <li>Orders</li>
            <li>My Account</li>
            <li>Help Centre</li>
            <li>Cart</li>
            <li>List</li>
          </ul>
        </div>
      )}

      {/* Catalogue Section */}
      <main id="home-section" className="catalogue">
        <h2>Product Catalogue</h2>
        <input
          type="text"
          placeholder="Search products..."
          value={searchTerm}
          onChange={handleSearch}
          className="search-bar"
        />
        <ul className="product-list">
          {products
            .filter((product) =>
              product.title.toLowerCase().includes(searchTerm.toLowerCase())
            )
            .map((product) => (
              <li key={product.id} className="product-item">
                <img
                  src={product.image}
                  alt={product.title}
                  className="product-image"
                />
                <span>
                  {product.title} - ${product.price}
                </span>
                <button onClick={() => handleAddToCart(product)}>
                  Add to Cart
                </button>
              </li>
            ))}
        </ul>
      </main>
    </div>
  );
}

export default App;