import { useState, useEffect } from "react";

export default function Graj() {
  const [multiplier, setMultiplier] = useState(0.0);  // Początkowy mnożnik
  const [bet, setBet] = useState(0);  // Stawka
  const [multiplierValue, setMultiplierValue] = useState(2);  // Suwak mnożnika

  const [gameStarted, setGameStarted] = useState(false);
  const [timer, setTimer] = useState(null);

  useEffect(() => {
    let interval;
    if (gameStarted) {
      interval = setInterval(() => {
        setMultiplier((prev) => (prev + 0.1).toFixed(1)); // Zwiększamy mnożnik co 100ms
      }, 100); // Co 100ms dodajemy 0.1 do mnożnika
    } else {
      setMultiplier(0.0);  // Resetujemy mnożnik, gdy gra się kończy
    }

    return () => clearInterval(interval); // Czyszczenie interwału po zakończeniu gry
  }, [gameStarted]);

  const handleStartGame = () => {
    if (bet <= 0) {
      alert("Proszę postawić stawkę!");
      return;
    }
    setGameStarted(true);
    setMultiplier(0.0);  // Resetujemy mnożnik przed startem
  };

  return (
    <div style={styles.container}>
      {/* Mnożnik */}
      <div style={styles.multiplier}>
        <h2 style={styles.title}>Mnożnik: {multiplier}x</h2>
      </div>

      {/* Stawka i suwak */}
      <div style={styles.controls}>
        <div style={styles.control}>
          <label style={styles.label}>Stawka:</label>
          <input
            type="number"
            value={bet}
            onChange={(e) => setBet(e.target.value)}
            style={styles.input}
          />
        </div>
        <div style={styles.control}>
          <label style={styles.label}>Mnożnik:</label>
          <input
            type="range"
            min="1"
            max="50"
            value={multiplierValue}
            onChange={(e) => setMultiplierValue(e.target.value)}
            style={styles.slider}
          />
          <span style={styles.rangeValue}>{multiplierValue}x</span>
        </div>
      </div>

      {/* Guzik obstaw */}
      <button onClick={handleStartGame} style={styles.button}>
        Obstaw
      </button>
    </div>
  );
}

const styles = {
  container: {
    display: "flex",
    flexDirection: "column",
    alignItems: "center",
    justifyContent: "center",
    padding: "20px",
    backgroundColor: "#2a2a2a",
    borderRadius: "8px",
    width: "80%",
    maxWidth: "500px",
    margin: "0 auto",
    color: "white",
  },

  multiplier: {
    marginBottom: "40px",
  },

  title: {
    fontSize: "30px",
    fontWeight: "700",
  },

  controls: {
    width: "100%",
    marginBottom: "30px",
  },

  control: {
    marginBottom: "20px",
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between",
  },

  label: {
    fontSize: "18px",
  },

  input: {
    width: "100px",
    padding: "5px",
    marginLeft: "10px",
    fontSize: "16px",
    borderRadius: "4px",
    border: "1px solid #555",
    color: "black",
  },

  slider: {
    width: "200px",
    margin: "0 10px",
  },

  rangeValue: {
    fontSize: "18px",
    fontWeight: "500",
  },

  button: {
    backgroundColor: "#ff9800",
    color: "white",
    padding: "12px 25px",
    fontSize: "18px",
    border: "none",
    borderRadius: "6px",
    cursor: "pointer",
    fontWeight: "700",
    transition: "background 0.3s ease",
  },

  buttonHover: {
    backgroundColor: "#ff5722",
  },
};
