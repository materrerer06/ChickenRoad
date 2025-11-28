import { useState } from "react";
import Graj from './Play'

export default function Header() {
  const [open, setOpen] = useState(false);

  return (
    <header style={styles.header}>

      <div style={styles.left}>
        <div style={styles.logo}></div>
      </div>

      <div style={styles.center}>
        <a href="/Play" style={styles.centerLink}>Graj</a>
      </div>

      <nav style={styles.right}>
        <a href="/poradnik" style={styles.link}>Poradnik</a>

        <div style={styles.dropdownContainer}>
          <div
            style={styles.link}
            onClick={() => setOpen(!open)}
          >
            Profil ▾
          </div>

          {open && (
            <div style={styles.dropdown}>
              <a href="/historia" style={styles.dropdownItem}>Historia</a>
              <a href="/wplata" style={styles.dropdownItem}>Wpłać środki</a>
              <a href="/profil" style={styles.dropdownItem}>Mój profil</a>
            </div>
          )}
        </div>
      </nav>

    </header>
  );
}

const styles = {
  header: {
    width: "100%",
    height: "60px",
    background: "#1b1b1b",
    borderBottom: "1px solid #333",
    position: "fixed",
    top: 0,
    left: 0,
    zIndex: 1000,

    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",

    padding: "0 20px",
  },

  left: { display: "flex", alignItems: "center" },

  logo: {
    width: "40px",
    height: "40px",
    background: "white",
    borderRadius: "6px",
  },

  center: {
    position: "absolute",
    left: "49%",
    transform: "translateX(-51%)",
  },

  centerLink: {
    color: "white",
    fontSize: "20px",
    fontWeight: "700",
    textDecoration: "none",
  },

  right: {
    display: "flex",
    alignItems: "center",
    gap: "25px",
    marginLeft: "auto",
    marginRight: "40px",
    position: "relative",
  },

  link: {
    color: "white",
    textDecoration: "none",
    fontSize: "16px",
    cursor: "pointer",
  },

  dropdownContainer: {
    position: "relative",
  },

  dropdown: {
    position: "absolute",
    top: "40px",
    right: 0,
    background: "#2a2a2a",
    border: "1px solid #444",
    borderRadius: "6px",
    overflow: "hidden",
    minWidth: "160px",
    display: "flex",
    flexDirection: "column",
    zIndex: 2000,
  },

  dropdownItem: {
    padding: "10px 15px",
    color: "white",
    textDecoration: "none",
    fontSize: "15px",
    borderBottom: "1px solid #3a3a3a",
  },
};
