package io.github.gdonega.shortcuts.config;

import lc.kra.system.keyboard.event.GlobalKeyEvent;

import static lc.kra.system.keyboard.event.GlobalKeyEvent.*;
public enum Shortcuts {
    NEW_GUID(false, false, true, true, true, VK_X),
    NEW_CPF(false, false, true, true, true, VK_F3),
    NEW_CNPJ(false, false, true, true, true, VK_F4),
    NEW_CEP(false, false, true, true, true, VK_F5),
    TELEFONE(false, false, true, true, true, VK_F6),
//    SHORTCUT_INUTIL(false, false, true, true, true, VK_F7),
//    SHORTCUT_INUTIL(false, false, true, true, true, VK_F8)
    ;
    private final boolean isExtendedKey;
    private final boolean isWinPressed;
    private final boolean isAltPressed;
    private final boolean isShiftPressed;
    private final boolean isControlPressed;
    private final int key;

    Shortcuts(boolean isExtendedKey, boolean isWinPressed, boolean isAltPressed, boolean isShiftPressed, boolean isControlPressed, int key) {
        this.isExtendedKey = isExtendedKey;
        this.isWinPressed = isWinPressed;
        this.isAltPressed = isAltPressed;
        this.isShiftPressed = isShiftPressed;
        this.isControlPressed = isControlPressed;
        this.key = key;
    }

    public static Shortcuts findByEvent(GlobalKeyEvent e) {
        // Vai para cada shortcut definido
        for (Shortcuts s : Shortcuts.values()) {
            // ExtendedKey: O estado ('é' ou 'não é') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.isExtendedKey != e.isExtendedKey()) continue;

            // WIN: O estado ('pressionado' ou 'não pressionado') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.isWinPressed != e.isWinPressed()) continue;

            // ALT: O estado ('pressionado' ou 'não pressionado') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.isAltPressed != e.isMenuPressed()) continue;

            // SHIFT: O estado ('pressionado' ou 'não pressionado') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.isShiftPressed != e.isShiftPressed()) continue;

            // CONTROL: O estado ('pressionado' ou 'não pressionado') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.isControlPressed != e.isControlPressed()) continue;

            // TECLA: O estado ('pressionado' ou 'não pressionado') definido pelo Shortcut deve ser o mesmo q está ocorrendo no evento.
            if (s.key != e.getVirtualKeyCode()) continue;

            // Caso tenha chegado até aqui: esse é o shortcut sendo pressionado
            return s;
        }

        // Caso não tenha sido encontrado nenhum shortcut: retorna nulo
        return null;
    }

    // Getters
    public boolean isExtendedKey() {
        return isExtendedKey;
    }

    public boolean isWinPressed() {
        return isWinPressed;
    }

    public boolean isAltPressed() {
        return isAltPressed;
    }

    public boolean isShiftPressed() {
        return isShiftPressed;
    }

    public boolean isControlPressed() {
        return isControlPressed;
    }

    public int getKey() {
        return key;
    }
}
