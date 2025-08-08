package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException() {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenCellIsOccupied() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        PawnBlack pawnBlack = new PawnBlack(Cell.A3);
        logic.add(bishopBlack);
        logic.add(pawnBlack);
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () -> {
            logic.move(Cell.B2, Cell.A3);
        });
        assertThat(exception.getMessage()).isEqualTo("Occupied cell exception");
    }

    @Test
    public void whenImpossibleMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B2);
        logic.add(bishopBlack);
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () -> {
            logic.move(Cell.B2, Cell.C2);
        });
        assertThat(exception.getMessage()).isEqualTo("Could not move by diagonal from B2 to C2");

    }
}
