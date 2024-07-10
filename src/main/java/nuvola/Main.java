package nuvola;

import nuvola.command.ResizeWindowCommand;
import nuvola.managers.inputmanager.InputManager;
import nuvola.command.CloseGameCommand;
import nuvola.command.Command;
import nuvola.managers.inputmanager.input.CloseWindowInput;
import nuvola.managers.inputmanager.input.KeyInput;
import nuvola.managers.inputmanager.input.ResizeWindowInput;
import nuvola.managers.inputmanager.inputlistener.*;
import nuvola.managers.rendermanager.Mesh;
import nuvola.managers.rendermanager.RenderComponent;
import nuvola.managers.rendermanager.RenderManager;
import nuvola.managers.rendermanager.buffer.vertex.Vertex;
import nuvola.managers.rendermanager.buffer.vertex.attribute.ColorAttribute;
import nuvola.managers.rendermanager.buffer.vertex.attribute.PositionAttribute;
import nuvola.managers.rendermanager.buffer.vertex.attribute.TextureCoordinatesAttribute;
import nuvola.managers.rendermanager.shader.ShaderProgram;
import nuvola.managers.rendermanager.texture.Texture;
import nuvola.managers.transform.Position;
import nuvola.managers.transform.Rotation;
import nuvola.managers.transform.Scale;
import nuvola.managers.transform.Transform;
import nuvola.managers.windowmanager.Window;
import nuvola.mapping.InputCommandMapping;
import org.joml.Vector3f;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputCommandMapping mapping = new InputCommandMapping();

        Window window = new Window("Trial", 1080, 720);
        InputListener keyListener = new KeyListener(window);
        InputListener clickListener = new ClickListener(window);
        InputListener mouseListener = new MouseListener(window);
        InputListener scrollListener = new ScrollListener(window);
        InputListener closeListener = new CloseWindowListener(window);
        InputListener resizeListener = new ResizeWindowListener(window);

        window.setClearColor(0.3f, 0.3f, 0.3f);

        InputManager inputManager = new InputManager(List.of(keyListener, clickListener, mouseListener, scrollListener, closeListener, resizeListener), mapping);

        ShaderProgram shader = new ShaderProgram("src/main/resources/shaders/vertexShaders/vertexShader.vert",
                "src/main/resources/shaders/fragmentShaders/fragmentShader.frag");
        RenderManager renderManager = new RenderManager(shader, window);
        renderManager.addComponent(createSimpleComponent());

        Engine engine = new Nuvola(window, inputManager, renderManager);

        Command closeCommand = new CloseGameCommand(engine);
        mapping.addMapping(new KeyInput(256, 1, 0), closeCommand);
        mapping.addMapping(new CloseWindowInput(), closeCommand);
        mapping.addDynamicMapping(
                ResizeWindowInput.class,
                input ->  new ResizeWindowCommand(window, ((ResizeWindowInput) input).width,  ((ResizeWindowInput) input).height)
        );

        engine.run();
        engine.shutdown();
    }

    public static RenderComponent createSimpleComponent() {
        List<Vertex> vertices = List.of(
                new Vertex(List.of(
                        new PositionAttribute(-0.5f, -0.5f, 0),
                        new ColorAttribute(1f, 0f, 0f),
                        new TextureCoordinatesAttribute(0, 0))),
                new Vertex(List.of(
                        new PositionAttribute(0.5f, -0.5f, 0),
                        new ColorAttribute(0f, 1f, 0f),
                        new TextureCoordinatesAttribute(1, 0))),
                new Vertex(List.of(
                        new PositionAttribute(-0.5f, 0.5f, 0),
                        new ColorAttribute(0, 0f, 1f),
                        new TextureCoordinatesAttribute(0, 1))),
                new Vertex(List.of(
                        new PositionAttribute(0.5f, 0.5f, 0),
                        new ColorAttribute(0.5f, 0.5f, 0.5f),
                        new TextureCoordinatesAttribute(1, 1)))
        );

        List<Integer> indices = List.of(0, 1, 2, 2, 1, 3);
        Texture texture = new Texture("src/main/resources/textures/suricati.jpg");
        Mesh mesh = new Mesh(vertices, indices, List.of(texture));
        Transform transform = new Transform(Position.ORIGIN(), new Scale(100), new Rotation(new Vector3f(1, 0, 0), (float) Math.toRadians(0)));

        return new RenderComponent(mesh, transform);
    }
}