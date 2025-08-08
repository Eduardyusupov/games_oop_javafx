package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BishopBlackTest {

    @Test
    public void checkPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A3);
        Cell expected = Cell.A3;
        Cell actual = bishopBlack.position();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void checkCopy() {
        Figure bishopBlack = new BishopBlack(Cell.A3);
        Cell expected = Cell.A1;
        Figure bishopCopy = bishopBlack.copy(Cell.A1);
        assertThat(expected).isEqualTo(bishopCopy.position());
    }

    @Test
    public void isDiagonalTrue() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Cell firstPosition = Cell.A3;
        Cell secondPosition = Cell.B2;
        assertThat(bishop.isDiagonal(firstPosition, secondPosition)).isTrue();
    }

    @Test
    public void isDiagonalFalse() {
        BishopBlack bishop = new BishopBlack(Cell.A3);
        Cell firstPosition = Cell.A3;
        Cell secondPosition = Cell.A2;
        assertThat(bishop.isDiagonal(firstPosition, secondPosition)).isFalse();
    }

    @Test
    public void whenWayCorrect() {
        BishopBlack bishopFirstPosition = new BishopBlack(Cell.H1);
        Cell[] way = {Cell.G2, Cell.F3};
        assertThat(way).isEqualTo(bishopFirstPosition.way(Cell.F3));
    }

}
