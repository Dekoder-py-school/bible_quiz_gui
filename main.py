import customtkinter as tk
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

        self.root = tk.CTk()
        self.root.title("Bible Quiz")
        self.root.geometry("800x400")
        tk.set_default_color_theme("./mocha.json")

        self.question_label = tk.CTkLabel(self.root)
        self.answer_field = tk.CTkEntry(self.root)
        self.submit_button = tk.CTkButton(self.root, text="Check", command=self.check)
        self.marking_label = tk.CTkLabel(self.root)

        self.question_label.grid(column=0, row=0, columnspan=6)
        self.answer_field.grid(column=0, row=1)
        self.submit_button.grid(column=1, row=1)
        self.marking_label.grid(column=0, row=3)

    def load_question(self) -> None:
        if self.q_index > len(self.questions):
            self.end()
        else:
            self.question_label.configure(text=self.questions[self.q_index]["q"])

    def check(self) -> None:
        if self.answer_field.get() == self.questions[self.q_index]["a"]:
            self.correct()

    def correct(self) -> None:
        self.q_index += 1
        self.submit_button.configure(text="Next")
        self.submit_button.configure(command=self.load_question)
        self.marking_label.configure(text="Correct!", foreground="#40a02b")

    def incorrect(self) -> None:
        pass

    def end(self) -> None:
        pass

    def run(self) -> None:
        self.load_question()
        self.root.mainloop()


if __name__ == "__main__":
    app = App()
    app.run()
