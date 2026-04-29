import tkinter as tk
from tkinter import ttk


class App:
    def __init__(self) -> None:
        self.root = tk.Tk()
        self.root.title("Bible Quiz")

    def run(self):
        self.root.mainloop()


if __name__ == "__main__":
    app = App()
    app.run()
