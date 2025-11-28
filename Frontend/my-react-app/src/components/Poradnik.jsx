import { useState, useEffect } from "react";
import { Link } from "react-router-dom";
export default function Poradnik() {
  return (
    <div style={styles.container}>
      <h1 style={styles.title}>Poradnik — Crash Game</h1>
      <div style={styles.section}>
        <h2 style={styles.subtitle}>1. Jak postawić stawkę?</h2>
        <p style={styles.text}>
          Aby rozpocząć grę, musisz wybrać kwotę, którą chcesz zainwestować.
          Wybierz wartość stawki, którą chcesz zagrać, i potwierdź wybór, aby
          przejść do następnego kroku.
        </p>
      </div>

      <div style={styles.section}>
        <h2 style={styles.subtitle}>2. Ustaw mnożnik</h2>
        <p style={styles.text}>
          Następnie wybierz mnożnik, który określi, ile razy Twoja stawka
          zostanie pomnożona, jeśli wygrasz. Im wyższy mnożnik, tym wyższa
          potencjalna wygrana, ale pamiętaj — ryzyko również rośnie.
        </p>
      </div>

      <div style={styles.section}>
        <h2 style={styles.subtitle}>3. Jak działa gra?</h2>
        <p style={styles.text}>
          Gra polega na postawieniu stawki oraz wybraniu mnożnika. Gra zaczyna się
          od momentu kliknięcia „Graj”. Po rozpoczęciu gry mnożnik będzie
          stopniowo wzrastał, a Twoim celem jest wycofać stawkę przed
          "crashem". Jeśli uda Ci się wycofać przed upadkiem, wygrywasz
          pomnożoną stawkę. Jeśli nie, tracisz całą stawkę.
        </p>
      </div>
    </div>
  );
}

const styles = {
  container: {
    padding: "30px",
    maxWidth: "800px",
    margin: "0 auto",
    backgroundColor: "#2a2a2a",
    borderRadius: "8px",
    color: "white",
  },
  title: {
    textAlign: "center",
    fontSize: "30px",
    marginBottom: "20px",
  },
  section: {
    marginBottom: "20px",
  },
  subtitle: {
    fontSize: "22px",
    marginBottom: "10px",
    color: "#ff9800", // Możesz zmienić na dowolny kolor
  },
  text: {
    fontSize: "16px",
    lineHeight: "1.5",
  },
};
