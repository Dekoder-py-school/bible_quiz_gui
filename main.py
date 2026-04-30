import tkinter as tk
from curses import COLOR_GREEN
from tkinter import ttk


class App:
    def __init__(self) -> None:
        self.questions = [
            {
                "q": "How many books are in the Bible?",
                "a": "73",
            }
        ]
        self.q_index = 0

        self.root = tk.Tk()
        self.root.title("Bible Quiz")
        self.root.geometry("800x400")
        self.question_label = ttk.Label(self.root)
        self.answer_field = ttk.Entry(self.root)
        self.submit_button = ttk.Button(self.root, text="Submit!", command=self.check)
        self.marking_label = ttk.Label(self.root)

        self.question_label.grid(column=0, row=0, columnspan=6)
        self.answer_field.grid(column=0, row=1)
        self.submit_button.grid(column=0, row=2)
        self.marking_label.grid(column=0, row=3)

    def load_question(self) -> None:
        self.question_label.config(text=self.questions[self.q_index]["q"])

    def check(self) -> None:
        if self.answer_field.get() == self.questions[self.q_index]["a"]:
            self.correct()

    def correct(self) -> None:
        self.submit_button.config(text="Next")
        self.marking_label.config(text="Correct!", foreground="#40a02b")

    def run(self) -> None:
        self.load_question()
        self.root.mainloop()


if __name__ == "__main__":
    app = App()
    app.run()
