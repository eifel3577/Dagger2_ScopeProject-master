package ru.startandroid.scopeproject.mail;

import dagger.Subcomponent;
import ru.startandroid.scopeproject.folders.FolderListActivityComponent;
import ru.startandroid.scopeproject.letters.LetterListActivityComponent;
import ru.startandroid.scopeproject.letters.LetterListActivityModule;

/**MailComponent - создается на время работы с почтой. Его синглтон - это класс для работы с
 * почтой MailManager. */
@MailScope
@Subcomponent(modules = MailModule.class)
public interface MailComponent {

    FolderListActivityComponent createFoldersListActivityComponent();

    LetterListActivityComponent createLetterListActivityComponent(LetterListActivityModule letterListActivityModule);

}
