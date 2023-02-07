package io.github.gdonega.shortcuts;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import io.github.gdonega.shortcuts.config.Shortcuts;
import io.github.gdonega.shortcuts.generators.BrazilCepGenerator;
import lc.kra.system.keyboard.GlobalKeyboardHook;
import lc.kra.system.keyboard.event.GlobalKeyAdapter;
import lc.kra.system.keyboard.event.GlobalKeyEvent;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.UUID;

import static io.github.gdonega.shortcuts.config.Shortcuts.findByEvent;
import static java.awt.event.KeyEvent.*;

public class Main {
    public static void main(String[] args) {
        new GlobalKeyboardHook(true).addKeyListener(new GlobalKeyAdapter() {
            @Override
            public void keyPressed(GlobalKeyEvent e) {
                // Tenta recuperar o shortcut
                Shortcuts s = findByEvent(e);

                // Se o valor do shortcut for nulo: já retorna
                if (s == null) return;

                // Caso contrário: executa ação necessária
                switch (s) {
                    case NEW_GUID -> saveOnClipBoard(UUID.randomUUID().toString());
                    case NEW_CPF -> saveOnClipBoard((new CPFValidator(false)).generateRandomValid());
                    case NEW_CNPJ  -> saveOnClipBoard((new CNPJValidator(false)).generateRandomValid());
                    case NEW_CEP -> saveOnClipBoard(BrazilCepGenerator.generate());
                    case TELEFONE -> {}
                }
            }

            @Override
            public void keyReleased(GlobalKeyEvent e) {
                // Tenta recuperar o shortcut
                Shortcuts s = findByEvent(e);

                // Se o valor do shortcut for nulo: já retorna
                if (s == null) return;

                // Caso contrário: cola a informação
                pasteAnywhere();
            }
        });
    }

    public static void saveOnClipBoard(String content) {
        System.out.println(content);
        StringSelection selection = new StringSelection(content);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
    }

    public static void pasteAnywhere() {
        try {
            // Instancia o robot
            Robot r = new Robot();

            // Libera teclas especiais
            r.keyRelease(VK_SHIFT);
            r.keyRelease(VK_CONTROL);
            r.keyRelease(VK_ALT);
            r.keyRelease(VK_WINDOWS);

            // Espera 1 ms
            Thread.sleep(1);

            // Pressiona: ctrol v
            r.keyPress(VK_CONTROL);
            r.keyPress(VK_V);

            // Solta: ctrol v
            r.keyRelease(VK_V);
            r.keyRelease(VK_CONTROL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}