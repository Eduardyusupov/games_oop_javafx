package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not move by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = position.getX();
        int deltaY = position.getY();
        for (int index = 0; index < size; index++) {
            if (size > 0) {
                deltaX--;
                deltaY--;
            } else {
                deltaX++;
                deltaY++;
            }
            steps[index] = Cell.findBy(deltaX, deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean isDiagonal = false;
        int x1 = Math.abs(source.getX() - dest.getX());
        int y1 = Math.abs(source.getY() - dest.getY());
        if (x1 == y1) {
            isDiagonal = true;
        }
        return isDiagonal;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
