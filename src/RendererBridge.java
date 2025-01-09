class RendererBridge {
  private final Renderer renderer;

  public RendererBridge(Renderer renderer) {
    this.renderer = renderer;
  }

  public void display(int size) {
    renderer.render(size);
  }
}