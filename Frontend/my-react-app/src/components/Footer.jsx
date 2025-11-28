export default function Footer() {
  return (
    <footer style={styles.footer}>
      <div style={styles.container}>
        <p style={styles.text}>© 2025 CrashGame. Wszystkie prawa zastrzeżone.</p>
      </div>
    </footer>
  );
}

const styles = {
  footer: {
    position: "absolute",
    left: 0,
    bottom: 0,
    width: "100%",
    backgroundColor: "#1b1b1b",
    color: "white",
    padding: "15px 0",
    textAlign: "center",
    zIndex: 1000,
  },
  container: {
    display: "flex",
    justifyContent: "center",
    alignItems: "center",
  },
  text: {
    fontSize: "14px",
  },
};
