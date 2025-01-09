class RendererBridge {
  private final Renderer renderer;
  private final int size;

  public RendererBridge(Renderer renderer, int size) {
    this.renderer = renderer;
    this.size = size;
  }

  public void display() {
    renderer.render(size);
  }
}